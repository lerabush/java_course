public enum Role {
    STAFF(0.1,3000),
    EXECUTIVE(0.3,5000),
    MANAGER(0.2,4000);
    private Double percent;
    private Integer salary;
    Role(Double percent,Integer money){
        this.percent = percent;
        this.salary = money;
    }
    public Double getPercent(){
        return percent;
    }
    public Integer getSalary(){ return salary;};
    public void setSalary(Integer newSalary){
        this.salary = newSalary;
    }
}
