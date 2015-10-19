package fr.mga.livecoding;

public class Result {

	private String departement;
	private String manager;
	private Double netProfit;
	private Double operatingExpense;
    private boolean isUnderKpi;
    private boolean hasTooMuchExpense;
    private int year;
    private int turnover;
    private String underKpiMessage;

    public String getUnderKpiMessage() {
        return underKpiMessage;
    }

    public void setUnderKpiMessage(String underKpiMessage) {
        this.underKpiMessage = underKpiMessage;
    }

    public String getTooMuchExpenseMessage() {
        return tooMuchExpenseMessage;
    }

    public void setTooMuchExpenseMessage(String tooMuchExpenseMessage) {
        this.tooMuchExpenseMessage = tooMuchExpenseMessage;
    }

    private String tooMuchExpenseMessage;


    public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	public Double getNetProfit() {
		return netProfit;
	}
	public void setNetProfit(Double netProfit) {
		this.netProfit = netProfit;
	}
	public Double getOperatingExpense() {
		return operatingExpense;
	}

    public boolean getUnderKpi() {
        return isUnderKpi;
    }
	public void setOperatingExpense(Double operatingExpense) {
		this.operatingExpense = operatingExpense;
	}

    public void setUnderKpi(boolean underKpi) {
        this.isUnderKpi = underKpi;
    }

    public boolean getHasTooMuchExpense() {
        return hasTooMuchExpense;
    }

    public void setHasTooMuchExpense(boolean hasTooMuchExpense) {
        this.hasTooMuchExpense = hasTooMuchExpense;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTurnover() {
        return turnover;
    }

    public void setTurnover(int turnover) {
        this.turnover = turnover;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result = (Result) o;

        if (turnover != result.turnover) return false;
        if (year != result.year) return false;
        if (departement != null ? !departement.equals(result.departement) : result.departement != null) return false;
        if (manager != null ? !manager.equals(result.manager) : result.manager != null) return false;
        if (netProfit != null ? !netProfit.equals(result.netProfit) : result.netProfit != null) return false;
        if (operatingExpense != null ? !operatingExpense.equals(result.operatingExpense) : result.operatingExpense != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = departement != null ? departement.hashCode() : 0;
        result = 31 * result + (manager != null ? manager.hashCode() : 0);
        result = 31 * result + (netProfit != null ? netProfit.hashCode() : 0);
        result = 31 * result + (operatingExpense != null ? operatingExpense.hashCode() : 0);
        result = 31 * result + year;
        result = 31 * result + turnover;
        return result;
    }

    public void handleExpense(int maxExpense) {
        if(getOperatingExpense() >= maxExpense) {
            setHasTooMuchExpense(true);
            setTooMuchExpenseMessage("ALERT EXPENSE");
        }
    }

    public void handleProfit(int minProfit) {
        if(getNetProfit() < minProfit) {
            setUnderKpi(true);
            setUnderKpiMessage("ALERT KPI");
        }
    }

    public boolean is(String department) {
        return getDepartement() == department;
    }

    public void calculate() {
        if (!is("Media") && !is("Bank") && !is("Indus")) {
            handleProfit(5000);
            handleExpense(5000);
        } else {
            if (is("Media")) {
                handleProfit(7500);
                handleExpense(4200);
            }
            if(is("Bank")) {
                handleProfit(10000);
            }
            if(is("Indus")) {
                handleExpense(1000);
            }
        }
    }
}


