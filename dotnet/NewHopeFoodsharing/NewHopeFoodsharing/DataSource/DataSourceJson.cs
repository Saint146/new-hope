using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
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
			JObject obj = JObject.Parse(dataJson);

			if (actType == ActType.Accept)
			{
				const string productsKey = "products";

				var productsArr = obj.Value<JArray>(productsKey);

				TableData = productsArr.ToObject<List<Dictionary<string, string>>>();

				productsArr.Remove();
			}

			StringData = obj.ToObject<Dictionary<string, string>>();
		}
	}
}
