package statistics;

import statistics.matcher.All;
import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.Or;
import statistics.matcher.PlaysIn;

public class QueryBuilder {
	Matcher m;
	
	public QueryBuilder(Matcher m) {
		this.m = m;
	}
	
	public QueryBuilder() {
		this(new All());
	}
	
	public QueryBuilder playsIn(String team) {
		return new QueryBuilder(new And(this.m, new PlaysIn(team)));
	}
	
	public QueryBuilder hasAtLeast(int value, String category) {
		return new QueryBuilder(new And(this.m, new HasAtLeast(value, category)));
	}
	
	public QueryBuilder hasFewerThan(int value, String category) {
		return new QueryBuilder(new And(this.m, new HasFewerThan(value, category)));
	}
	
	public QueryBuilder oneOf(Matcher... matchers) {
		return new QueryBuilder(new Or(matchers));
	}
	
	public Matcher build() {
		return this.m;
	}
}
