using iTextSharp.text;
using iTextSharp.text.pdf;
using System;
using System.Collections.Generic;
using System.IO;
using System.Text;

namespace NewHopeFoodsharing.ActExport
{
	public abstract class ActExporter
	{
		public ActExporter()
		{
			// инициализируем шрифт именно так, потому что по-другому кодировку переключить просто нельзя
			// https://stackoverflow.com/questions/1727765/itextsharp-international-text/1729278

			string timesTtf = Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.Fonts), "times.ttf");
			var baseFont = BaseFont.CreateFont(timesTtf, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

			font = new Font(baseFont, 12, Font.NORMAL, Color.BLACK);
		}

		public Dictionary<string, string> StringData = new Dictionary<string, string>();
		public List<Dictionary<string, string>> TableData = new List<Dictionary<string, string>>();

		protected Font font;

		public string Export(string fileName)
		{
			FileStream fileStream = new FileStream(fileName, FileMode.Create);
			try
			{
				Document document = new Document(PageSize.A4, 60, 40, 40, 40);
				PdfWriter pdfWriter = PdfWriter.GetInstance(document, fileStream);

				document.Open();

				FillDocument(document);

				document.Close();
				pdfWriter.Close();
			}
			finally
			{
				fileStream.Close();
			}

			return fileName;
		}

		protected virtual void FillDocument(Document document)
		{ }

		protected string S(string stringId)
		{
			return StringData[stringId];
		}

		protected Phrase P(string text = "")
		{
			return new Phrase(text, font);
		}

		protected Paragraph Par(string text = "", int align = Element.ALIGN_LEFT)
		{
			return new Paragraph(P(text))
			{
				Alignment = align,
				FirstLineIndent = 40,
				SpacingAfter = 10,
				MultipliedLeading = 1.3f
			};
		}

		protected PdfPCell C(string text = "", int align = Element.ALIGN_LEFT, int border = Rectangle.TOP_BORDER | Rectangle.BOTTOM_BORDER | Rectangle.LEFT_BORDER | Rectangle.RIGHT_BORDER)
		{
			return new PdfPCell(P(text))
			{
				Padding = 7,
				HorizontalAlignment = align,
				VerticalAlignment = Element.ALIGN_MIDDLE,
				Border = border
			};
		}
	}
}