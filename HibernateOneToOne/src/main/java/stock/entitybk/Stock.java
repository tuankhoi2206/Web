package stock.entitybk;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "stock", catalog = "testdb", uniqueConstraints = {
		@UniqueConstraint(columnNames = "STOCK_NAME"),
		@UniqueConstraint(columnNames = "STOCK_CODE") })
public class Stock implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer stockId;
	private String stockCode;
	private String stockName;
	private Set<StockDailyRecord> stockDailyRecords = new HashSet<StockDailyRecord>(
			0);

	public Stock() {
	}

	public Stock(String stockCode, String stockName) {
		this.stockCode = stockCode;
		this.stockName = stockName;
	}

	public Stock(String stockCode, String stockName,
			Set<StockDailyRecord> stockDailyRecords) {
		this.stockCode = stockCode;
		this.stockName = stockName;
		this.stockDailyRecords = stockDailyRecords;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "STOCK_ID", unique = true, nullable = false)
	public Integer getStockId() {
		return this.stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	@Column(name = "STOCK_CODE", nullable = false, length = 10)
	// @Column(name = "STOCK_CODE", unique = true, nullable = false, length =
	// 10)
	public String getStockCode() {
		return this.stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	@Column(name = "STOCK_NAME", unique = true, nullable = false, length = 20)
	public String getStockName() {
		return this.stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	/*
	 * láº¥y tham chiáº¿u nhÆ° nÃ o tÃ¬m má»‘i quan há»‡ trÃªn Ä‘á»‘i tÆ°á»£ng
	 * stock mappedBy tá»± Ä‘á»™ng tÃ¬m Ä‘á»‘i tÆ°á»£ng tÆ°Æ¡ng á»©ng dá»±a vÃ o
	 * gÃ¬ Ä‘á»ƒ xÃ¡c Ä‘á»‹nh Ä‘á»‘i tÆ°á»£ng Ä‘Æ°á»£c Ã¡nh xáº¡ dá»±a vÃ o
	 * Ä‘á»‘i tÆ°á»£ng stock bÃªn class stockDaily
	 */
	// the participating classes is referred to as managing the relationship
	/*
	 * if you don't use mappedby annotaion. then we will two foreign key column
	 * in both class. risk circular
	 */
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "stock")
	public Set<StockDailyRecord> getStockDailyRecords() {
		return this.stockDailyRecords;
	}

	public void setStockDailyRecords(Set<StockDailyRecord> stockDailyRecords) {
		this.stockDailyRecords = stockDailyRecords;
	}

}
