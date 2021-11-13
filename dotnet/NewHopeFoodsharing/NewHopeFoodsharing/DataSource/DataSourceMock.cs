using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

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
					["DOC_TITLE"] = "Акт приема-передачи продовольственных товаров",
					["ANNEX_NUMBER"] = "1",
					["AGREEMENT_DATE"] = "29.02.2020",
					["AGREEMENT_NUMBER"] = "146",
					["LOCALITY"] = "г. Москва",
					["ACT_DATE"] = "13.11.2021",
					["ORG_NAME"] = "ООО «Шестёрочка»",
					["ORG_REPRESENTER"] = "Пупкин Иван Иванович",
					["ORG_REPRESENTER_GENITIVE"] = "Пупкина Ивана Ивановича",
					["ORG_ACCORDANCE"] = "ч. 1 ст. 182 ГК РФ (полномочия, вытекающие из окружающей обстановки)",
					["FS_NAME"] = "Автономная некоммерческая организация «Национальный центр спасения еды и заботы об экологии «Фудшеринг» (Распределение продуктов)»",
					["FS_REPRESENTER_GENITIVE"] = "Иванова Петра Сидоровича",
					["FS_REPRESENTER_ACCORDANCE"] = "Устава",
					["FS_VOLUNTEER"] = "Петрова Владислава Васильевна",
				};

				TableData = new List<Dictionary<string, string>>()
				{
					new Dictionary<string, string>()
					{
						["NAME"]="Хлеб дарницкий",
						["AMOUNT"]="10",
						["PRICE"]="65,50",
						["DUE_DATE"]="16.11.2021",
						["NOTE"]=" ",
					},
					new Dictionary<string, string>()
					{
						["NAME"]="Батон нарезной",
						["AMOUNT"]="25",
						["PRICE"]="34,00",
						["DUE_DATE"]="17.11.2021",
						["NOTE"]=" ",
					},
				};

				//for (int i = 1; i < 40; i++)
				//	exporter.TableData.Add(new TableRowInfo()
				//	{
				//		["NAME"] = "Хлеб дарницкий",
				//		["AMOUNT"] = "10",
				//		["PRICE"] = "65,50",
				//		["DUE_DATE"] = "16.11.2021",
				//		["NOTE"] = " ",
				//	});
			}
			else if(actType == ActType.Transfer)
			{
				StringData = new Dictionary<string, string>()
				{
					["DOC_TITLE"] = "Акт приема-передачи Пожертвования",
					["LOCALITY"] = "г. Москва",
					["ACT_DATE"] = "13.11.2021",
					["FS_NAME"] = "Автономная некоммерческая организация «Национальный центр спасения еды и заботы об экологии «Фудшеринг» (Распределение продуктов)»",
					["FS_SHORT_NAME"] = "АНО «Фудшеринг»",
					["FS_VOLUNTEER"] = "Петров Владислав Васильевич",
					["FS_VOLUNTEER_GENITIVE"] = "Петрова Владислава Васильевича",
					["FS_VOLUNTEER_ACCORDANCE"] = "доверенности",
					["PRODUCTS_SUM_AMOUNT"] = "100500",
					["TRANSFEREE"] = "Кукушкина Олеся Петровна",
					["TRANSFEREE_PHONE"] = "+794512365291",
					["TRANSFEREE_ACCORDANCE"] = "потому что"
				};
			}
		}

		public Dictionary<string, string> StringData { get; }

		public List<Dictionary<string, string>> TableData { get; }
	}
}
