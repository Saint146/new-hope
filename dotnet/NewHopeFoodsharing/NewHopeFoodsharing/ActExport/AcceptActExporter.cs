using iTextSharp.text;
using iTextSharp.text.pdf;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NewHopeFoodsharing.ActExport
{
	public class AcceptActExporter : ActExporter
	{
		protected override void FillDocument(Document document)
		{
			string title = "Акт приема-передачи продовольственных товаров";

			document.AddTitle(title);

			document.Add(Par($"Приложение № {S("annexNumber")}\nк Договору пожертвования\nпродовольственных товаров\n" +
			$"от {S("agreementDate")} № {S("agreementNumber")}", Element.ALIGN_RIGHT));

			document.Add(Par(title, Element.ALIGN_CENTER));

			PdfPTable table = new PdfPTable(2);
			table.WidthPercentage = 100;
			table.SetWidths(new int[] { 50, 50 });
			table.AddCell(C(S("locality"), Element.ALIGN_LEFT, Rectangle.NO_BORDER));
			table.AddCell(C(S("acceptanceDate"), Element.ALIGN_RIGHT, Rectangle.NO_BORDER));
			document.Add(table);

			document.Add(Par($"{S("organizationName")}, именуемое в дальнейшем «Жертвователь», в лице {S("organizationRepresenterGen")}, " +
			$"действующего на основании {S("organizationRepresenterAccordance")}, с одной стороны, и {S("fsName")}, именуемая в дальнейшем «Одаряемый», " +
			$"в лице {S("fsRepresenterGen")}, действующего на основании {S("fsRepresenterAccordance")}, " +
			$"с другой стороны, совместно именуемые «Стороны», составили настоящий Акт о нижеследующем:"));

			document.Add(Par($"1. Во исполнение Договора пожертвования продовольственных товаров от {S("agreementDate")} № {S("agreementNumber")} " +
			$"(далее — Договор) Жертвователь передал, а Одаряемый принял следующие продовольственные товары: "));

			table = new PdfPTable(6);
			table.WidthPercentage = 100;
			table.SetWidths(new int[] { 10, 25, 15, 15, 15, 20 });

			table.AddCell(C("№ п/п", Element.ALIGN_CENTER));
			table.AddCell(C("Наименование продовольственного товара", Element.ALIGN_CENTER));
			table.AddCell(C("Количество / вес", Element.ALIGN_CENTER));
			table.AddCell(C("Стоимость (руб./шт.)", Element.ALIGN_CENTER));
			table.AddCell(C("Срок годности", Element.ALIGN_CENTER));
			table.AddCell(C("Примечание", Element.ALIGN_CENTER));
			for (int i = 0; i < TableData.Count; i++)
			{
				var rowData = TableData[i];

				table.AddCell(C((i + 1).ToString(), Element.ALIGN_CENTER));
				table.AddCell(C(rowData["productName"]));
				table.AddCell(C(rowData["amount"], Element.ALIGN_CENTER));
				table.AddCell(C(rowData["price"], Element.ALIGN_CENTER));
				table.AddCell(C(rowData["expirationDate"], Element.ALIGN_CENTER));
				table.AddCell(C(rowData["note"]));
			}
			table.HeaderRows = 1;
			document.Add(table);

			document.Add(Par());

			document.Add(Par("2. Вышеуказанные продовольственные товары переданы безвозмездно."));

			document.Add(Par("3. Передаваемые продовольственные товары качественные, безопасные и соответствуют нормативным требованиям."));

			document.Add(Par("4. Одаряемый осмотрел и принял переданные Жертвователем продовольственные товары без замечаний."));

			document.Add(Par("5. Настоящий Акт составлен в двух экземплярах, по одному для каждой из Сторон."));

			document.Add(Par("6. Подписи Сторон:"));

			table = new PdfPTable(5);
			table.WidthPercentage = 100;
			table.SetWidths(new int[] { 10, 35, 10, 35, 10 });
			table.AddCell(C(border: Rectangle.NO_BORDER));
			table.AddCell(C("Жертвователь", Element.ALIGN_CENTER, Rectangle.NO_BORDER));
			table.AddCell(C(border: Rectangle.NO_BORDER));
			table.AddCell(C("Одаряемый", Element.ALIGN_CENTER, Rectangle.NO_BORDER));
			table.AddCell(C(border: Rectangle.NO_BORDER));

			table.AddCell(C(border: Rectangle.NO_BORDER));
			table.AddCell(C(border: Rectangle.NO_BORDER));
			table.AddCell(C(border: Rectangle.NO_BORDER));
			table.AddCell(C(border: Rectangle.NO_BORDER));
			table.AddCell(C(border: Rectangle.NO_BORDER));

			table.AddCell(C(border: Rectangle.NO_BORDER));
			table.AddCell(C(border: Rectangle.BOTTOM_BORDER));
			table.AddCell(C(border: Rectangle.NO_BORDER));
			table.AddCell(C(border: Rectangle.BOTTOM_BORDER));
			table.AddCell(C(border: Rectangle.NO_BORDER));
			document.Add(table);

			table = new PdfPTable(2);
			table.WidthPercentage = 100;
			table.SetWidths(new int[] { 50, 50 });
			table.AddCell(C($"/ {S("organizationRepresenter")} /", Element.ALIGN_CENTER, Rectangle.NO_BORDER));
			table.AddCell(C($"/ {S("volunteerName")} /", Element.ALIGN_CENTER, Rectangle.NO_BORDER));
			document.Add(table);
		}
	}
}
