using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NewHopeFoodsharing.DataSource
{
	public interface IDataSource
	{
		Dictionary<string, string> StringData { get; }
		List<Dictionary<string, string>> TableData { get; }
	}
}
