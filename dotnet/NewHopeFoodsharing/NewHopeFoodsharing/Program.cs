using NewHopeFoodsharing.ActExport;
using NewHopeFoodsharing.DataSource;
using System;
using System.Diagnostics;
using System.IO;

namespace NewHopeFoodsharing
{
	class Program
	{
		static void Main(string[] args)
		{
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

				var dataFileName = args[1];

				IDataSource source;
#if DEBUG
				source = new DataSourceMock(actType);
#else
				source = new DataSourceJson(actType, File.ReadAllText(dataFileName, Encoding.UTF8));
#endif

				// поля, не передаваемые снаружи, но присутствующие в шаблоне
				source.StringData.Add("annexNumber", "1");
				source.StringData.Add("fsRepresenterGen", "Иванова Петра Сидоровича");
				source.StringData.Add("fsRepresenterAccordance", "Устава");
				source.StringData.Add("fsName", "Автономная некоммерческая организация «Национальный центр спасения еды и заботы об экологии «Фудшеринг» (Распределение продуктов)»");
				source.StringData.Add("fsShortName", "АНО «Фудшеринг»");
				source.StringData.Add("volunteerAccordance", "доверенности");

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

				var fileName = exporter.Export(Path.ChangeExtension(dataFileName, ".pdf"));
				Console.WriteLine(fileName);
#if DEBUG
				Process.Start(fileName);
#endif
			}
#if DEBUG
#else
			catch (Exception ex)
			{
				Environment.ExitCode = 1;
				Console.WriteLine(ex.ToString());
			}
#endif
			finally
			{
			}
		}
	}
}