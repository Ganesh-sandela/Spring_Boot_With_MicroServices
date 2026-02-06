package in.ashokit.binding;

import java.util.List;

public class QuoteResponse {
	
	private List<Quote> quotes;

	public List<Quote> getQuotes() {
		return quotes;
	}

	@Override
	public String toString() {
		return "QuoteResponse [quote=" + quotes + "]";
	}

	public void setQuotes(List<Quote> quote) {
		this.quotes = quote;
	}

}
