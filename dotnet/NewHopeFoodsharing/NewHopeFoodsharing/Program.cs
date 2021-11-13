using NewHopeFoodsharing.ActExport;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using NewHopeFoodsharing.DataSource;

namespace NewHopeFoodsharing
{
	class Program
	{
		static void Main(string[] args)
		{
			string fileName = string.Empty;

			try
			{
#if DEBUG
				args = new string[] { "-accept", @"C:\Users\saint\Desktop\test.json" };
#endif

				if (args.Length < 1)
					throw new Exception("Не указан первый аргумент — тип акта");

				if (args.Length < 2)
					throw new Exception("Не указан второй аргумент — путь к файлу с данными");

				ActType actType;
				var actTypeStr = args[0];
				if (actTypeStr == "-accept")
					actType = ActType.Accept;
				else if (actTypeStr == "-transfer")
					actType = ActType.Transfer;
				else
					throw new Exception("Неверный тип акта. Возможные значения: -accept, -transfer");

				fileName = args[1];

#if DEBUG
				fileName = @"C:\Users\saint\Desktop\Act.pdf";
#endif
				IDataSource source;

#if DEBUG
				source = new DataSourceMock(actType);
#else
				source = new DataSourceJson(dataJson);
#endif

				ActExporter exporter;

				if (actType == ActType.Accept)
				{
					exporter = new AcceptActExporter()
					{
						StringData = source.StringData,
						TableData = source.TableData
					};
				}
				else if (actType == ActType.Transfer)
				{
					exporter = new TransferActExporter()
					{
						StringData = source.StringData
					};
				}
				else
					return;

				exporter.Export(fileName);
#if DEBUG
				Process.Start(fileName);
#endif
			}
			catch (Exception ex)
			{
				Environment.ExitCode = 1;
				Console.WriteLine(ex.ToString());

				if (File.Exists(fileName))
					File.WriteAllText(fileName, ex.ToString());
			}
		}
	}
}