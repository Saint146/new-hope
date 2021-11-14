using System.Collections.Generic;

namespace NewHopeFoodsharing.DataSource
{
	public class DataSourceMock : IDataSource
	{
		public DataSourceMock(ActType actType)
		{
			if (actType == ActType.Accept)
			{
				StringData = new Dictionary<string, string>()
				{
					["agreementDate"] = "29.02.2020",
					["agreementNumber"] = "146",
					["locality"] = "г. Москва",
					["acceptanceDate"] = "13.11.2021",
					["organizationName"] = "ООО «Шестёрочка»",
					["organizationRepresenter"] = "Пупкин Иван Иванович",
					["organizationRepresenterGen"] = "Пупкина Ивана Ивановича",
					["organizationRepresenterAccordance"] = "ч. 1 ст. 182 ГК РФ (полномочия, вытекающие из окружающей обстановки)",
					["volunteerName"] = "Петрова Владислава Васильевна",
				};

				TableData = new List<Dictionary<string, string>>()
				{
					new Dictionary<string, string>()
					{
						["productName"]="Хлеб дарницкий",
						["amount"]="10",
						["price"]="65,50",
						["expirationDate"]="16.11.2021",
						["note"]="",
					},
					new Dictionary<string, string>()
					{
						["productName"]="Батон нарезной",
						["amount"]="25",
						["price"]="34,00",
						["expirationDate"]="17.11.2021",
						["note"]="Всё ещё очень вкусно пахнет",
					},
				};

				//for (int i = 1; i < 40; i++)
				//	exporter.TableData.Add(new TableRowInfo()
				//	{
				//		["productName"] = "Хлеб дарницкий",
				//		["amount"] = "10",
				//		["price"] = "65,50",
				//		["expirationDate"] = "16.11.2021",
				//		["note"] = " ",
				//	});
			}
			else if(actType == ActType.Transfer)
			{
				StringData = new Dictionary<string, string>()
				{
					["locality"] = "г. Москва",
					["transferDate"] = "13.11.2021",
					["volunteerName"] = "Петров Владислав Васильевич",
					["volunteerNameGen"] = "Петрова Владислава Васильевича",
					["productsTotalAmount"] = "100500",
					["transfereeName"] = "Кукушкина Олеся Петровна",
					["transfereePhone"] = "+794512365291",
					["transfereeAccordance"] = "потому что"
				};
			}
		}

		public Dictionary<string, string> StringData { get; }

		public List<Dictionary<string, string>> TableData { get; }
	}
}
