using iTextSharp.text;
using iTextSharp.text.pdf;

namespace NewHopeFoodsharing.ActExport
{
	public class TransferActExporter : ActExporter
	{
		protected override void FillDocument(Document document)
		{
			string title = "Акт приема-передачи Пожертвования";

			document.AddTitle(title);

			document.Add(Par(title, Element.ALIGN_CENTER));

			PdfPTable table = new PdfPTable(2);
			table.WidthPercentage = 100;
			table.SetWidths(new int[] { 50, 50 });
			table.AddCell(C(S("locality"), Element.ALIGN_LEFT, Rectangle.NO_BORDER));
			table.AddCell(C(S("transferDate"), Element.ALIGN_RIGHT, Rectangle.NO_BORDER));
			document.Add(table);

			document.Add(Par($"{S("fsName")}, именуемая в дальнейшем «Жертвователь», в лице {S("volunteerNameGen")}, действующего на основании {S("volunteerAccordance")}, " +
			$"с одной стороны, и {S("transfereeName")}, именуемый в дальнейшем «Одаряемый», с другой стороны, совместно именуемые «Стороны», " +
			"составили настоящий Акт о нижеследующем:"));

			document.Add(Par($"1. Жертвователь передал, а Одаряемый принял продовольственные товары в количестве {S("productsTotalAmount")} единиц."));

			document.Add(Par("2. Вышеуказанные продовольственные товары переданы безвозмездно."));

			document.Add(Par("3. Одаряемый осмотрел и убедился в качестве, безопасности и соответствии нормативным требованиям переданных Жертвователем продовольственных товаров и принял их без замечаний."));

			document.Add(Par("4. Подписи Сторон:"));

			table = new PdfPTable(5);
			table.WidthPercentage = 100;
			table.SetWidths(new int[] { 10, 35, 10, 40, 5 });
			table.AddCell(C(border: Rectangle.NO_BORDER));
			table.AddCell(C("Жертвователь", Element.ALIGN_CENTER, Rectangle.NO_BORDER));
			table.AddCell(C(border: Rectangle.NO_BORDER));
			table.AddCell(C($"Одаряемый (тел. {S("transfereePhone")})", Element.ALIGN_CENTER, Rectangle.NO_BORDER));
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
			table.AddCell(C($"/ {S("volunteerName")} /", Element.ALIGN_CENTER, Rectangle.NO_BORDER));
			table.AddCell(C($"/ {S("transfereeName")} /", Element.ALIGN_CENTER, Rectangle.NO_BORDER));
			document.Add(table);

			document.Add(new Paragraph() { SpacingBefore = 45 });
			document.Add(Par($"Настоящим даю согласие {S("fsShortName")} на любое законное использование изображения и/или видеозаписи с моим участием, " +
			$"а также на обработку моих персональных данных для целей деятельности {S("fsShortName")}."));
			document.Add(new Paragraph() { SpacingAfter = 10 });

			table = new PdfPTable(4);
			table.WidthPercentage = 100;
			table.SetWidths(new int[] { 45, 10, 40, 5 });
			table.AddCell(C("Одаряемый", Element.ALIGN_RIGHT, Rectangle.NO_BORDER));
			table.AddCell(C(border: Rectangle.NO_BORDER));
			table.AddCell(C(border: Rectangle.BOTTOM_BORDER));
			table.AddCell(C(border: Rectangle.NO_BORDER));
			document.Add(table);

			table = new PdfPTable(2);
			table.WidthPercentage = 100;
			table.SetWidths(new int[] { 50, 50 });
			table.AddCell(C(border: Rectangle.NO_BORDER));
			table.AddCell(C($"/ {S("transfereeName")} /", Element.ALIGN_CENTER, Rectangle.NO_BORDER));
			document.Add(table);

			document.Add(new Paragraph() { SpacingBefore = 45 });
			document.Add(Par($"Настоящим подтверждаю наличие статуса получателя социальных льгот в соответствии с {S("transfereeAccordance")}."));
			document.Add(new Paragraph() { SpacingAfter = 10 });

			table = new PdfPTable(4);
			table.WidthPercentage = 100;
			table.SetWidths(new int[] { 45, 10, 40, 5 });
			table.AddCell(C("Одаряемый", Element.ALIGN_RIGHT, Rectangle.NO_BORDER));
			table.AddCell(C(border: Rectangle.NO_BORDER));
			table.AddCell(C(border: Rectangle.BOTTOM_BORDER));
			table.AddCell(C(border: Rectangle.NO_BORDER));
			document.Add(table);

			table = new PdfPTable(2);
			table.WidthPercentage = 100;
			table.SetWidths(new int[] { 50, 50 });
			table.AddCell(C(border: Rectangle.NO_BORDER));
			table.AddCell(C($"/ {S("transfereeName")} /", Element.ALIGN_CENTER, Rectangle.NO_BORDER));
			document.Add(table);
		}
	}
}
