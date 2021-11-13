using NewHopeFoodsharing.ActExport;
using System.Collections.Generic;
using System.Diagnostics;

namespace NewHopeFoodsharing
{
	class Program
	{
		static void Main(string[] args)
		{
			ActType actType = ActType.Transfer;

			const string filename = @"C:\Users\saint\Desktop\ActTransfer.pdf";

			ActExporter exporter;

			if (actType == ActType.Accept)
			{
				exporter = new AcceptActExporter();
				exporter.StringData = new Dictionary<string, string>()
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

				exporter.TableData = new List<TableRowInfo>()
				{
					new TableRowInfo()
					{
						["NAME"]="Хлеб дарницкий",
						["AMOUNT"]="10",
						["PRICE"]="65,50",
						["DUE_DATE"]="16.11.2021",
						["NOTE"]=" ",
					},
					new TableRowInfo()
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
			else if (actType == ActType.Transfer)
			{
				exporter = new TransferActExporter();
				exporter.StringData = new Dictionary<string, string>()
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
			else
				return;

			exporter.Export(filename);
			Process.Start(filename);
		}

		enum ActType
		{
			Accept,
			Transfer
		}
	}
}