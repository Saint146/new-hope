using System.Collections.Generic;

namespace NewHopeFoodsharing.DataSource
{
	public interface IDataSource
	{
		Dictionary<string, string> StringData { get; }
		List<Dictionary<string, string>> TableData { get; }
	}
}
