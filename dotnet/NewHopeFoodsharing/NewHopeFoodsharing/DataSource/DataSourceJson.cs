using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NewHopeFoodsharing.DataSource
{
	public class DataSourceJson : IDataSource
	{
		public Dictionary<string, string> StringData { get; }
		public List<Dictionary<string, string>> TableData { get; private set; }

		public DataSourceJson(ActType actType, string dataJson)
		{
			StringData = new Dictionary<string, string>();
			TableData = new List<Dictionary<string, string>>();

			JObject obj = JObject.Parse(dataJson);

			if (actType == ActType.Accept)
			{
				const string productsKey = "actItems";

				var productsArr = obj.Value<JArray>(productsKey);

				var tableDataRaw = productsArr.ToObject<List<Dictionary<string, string>>>();

				foreach (var tableEntryRaw in tableDataRaw)
				{
					var tableEntry = new Dictionary<string, string>();

					foreach (var fieldRaw in tableEntryRaw)
					{
						string val;

						if (fieldRaw.Key == "amount")
							val = double.Parse(fieldRaw.Value, CultureInfo.InvariantCulture).ToString("0.###", CultureInfo.GetCultureInfo(1049));
						else if (fieldRaw.Key == "price")
							val = double.Parse(fieldRaw.Value, CultureInfo.InvariantCulture).ToString("0.00", CultureInfo.GetCultureInfo(1049));
						else if (fieldRaw.Key == "expirationDate")
							val = DateTime.Parse(fieldRaw.Value, CultureInfo.InvariantCulture).ToString("d.MM.yyyy");
						else
							val = fieldRaw.Value;

						tableEntry.Add(fieldRaw.Key, val);
					}

					TableData.Add(tableEntry);
				}

				var stringDataRaw = obj.ToObject<Dictionary<string, object>>();

				foreach (var fieldRaw in stringDataRaw)
				{
					if (fieldRaw.Key == productsKey)
						continue;

					string val;

					if (fieldRaw.Key == "agreementDate")
						val = DateTime.Parse((string)fieldRaw.Value).ToString("D");
					else
						val = (string)fieldRaw.Value;

					StringData.Add(fieldRaw.Key, val);
				}
			}
			else if (actType == ActType.Transfer)
			{
				StringData = obj.ToObject<Dictionary<string, string>>();
			}
		}
	}
}
