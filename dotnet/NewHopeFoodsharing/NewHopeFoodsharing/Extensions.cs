using System.Collections.Generic;
using System.Linq;

namespace NewHopeFoodsharing
{
	internal static class Extensions
	{
		public static void Merge<TKey,TValue>(this Dictionary<TKey,TValue> dictionary1, Dictionary<TKey, TValue> dictionary2)
		{
			dictionary1 = dictionary1.Concat(dictionary2).ToDictionary(v => v.Key, v => v.Value);
		}
	}
}
