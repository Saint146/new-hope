using PdfSharp;
using PdfSharp.Pdf;
using System.Collections.Generic;
using System.IO;
using System.Reflection;
using System.Text;
using TheArtOfDev.HtmlRenderer.PdfSharp;

namespace NewHopeFoodsharing.ActExport
{
	public class ActExporter
	{
		public ActExporter() { }

		public string ActTemplateResourceName { set { actHtmlTemplate = ReadFromEmbeddedResource(value); } }
		public Dictionary<string, string> StringData = new Dictionary<string, string>();
		public Dictionary<string, List<TableRowInfo>> TableData = new Dictionary<string, List<TableRowInfo>>();

		string actHtmlTemplate;

		public string Export(string fileName)
		{
			var html = FillActTemplate();
			PdfDocument pdf = PdfGenerator.GeneratePdf(html, PageSize.A4);
			pdf.Save(fileName);

			return fileName;
		}

		string FillActTemplate()
		{
			string act = FillTemplate(actHtmlTemplate, StringData);

			foreach (var tableEntry in TableData)
			{
				var rowsStringData = tableEntry.Value;

				// загружаем шаблон одной строки
				string rowTemplate = ReadFromEmbeddedResource("NewHopeFoodsharing.ActExport.TableRowTemplate.html");
				StringBuilder rb = new StringBuilder();

				// добавляем заголовок
				rb.AppendLine(FillTemplate(rowTemplate, new Dictionary<string, string>()
				{
					["NUMBER"] = "№ п/п",
					["NAME"] = "Наименование продовольственного товара",
					["AMOUNT"] = "Количество / вес",
					["PRICE"] = "Стоимость (руб./шт.)",
					["DUE_DATE"] = "Срок годности",
					["NOTE"] = "Примечание",
				}));

				// заполняем строки данными
				for (int i = 0; i < rowsStringData.Count; i++)
				{
					// добавляем номер пункта
					rowsStringData[i].Add("NUMBER", (i + 1).ToString());

					rb.Append(FillTemplate(rowTemplate, rowsStringData[i]));
				}

				// загружаем шаблон таблицы
				StringBuilder tb = new StringBuilder(ReadFromEmbeddedResource("NewHopeFoodsharing.ActExport.TableTemplate.html"));

				// подставляем получившиеся строки в шаблон таблицы
				tb.Replace("[[ROWS]]", rb.ToString());

				// вставляем таблицу в нужное место документа
				act = act.Replace("[[" + tableEntry.Key + "]]", tb.ToString());
			}

			return act;
		}

		static string FillTemplate(string template, Dictionary<string, string> entries)
		{
			var sb = new StringBuilder(template);

			foreach (var stringEntry in entries)
			{
				sb.Replace($"[[{stringEntry.Key}]]", stringEntry.Value);
			}

			return sb.ToString();
		}

		static string ReadFromEmbeddedResource(string resourceFileName)
		{
			using (var stream = Assembly.GetExecutingAssembly().GetManifestResourceStream(resourceFileName))
			{
				return new StreamReader(stream).ReadToEnd();
			}
		}
	}
}
