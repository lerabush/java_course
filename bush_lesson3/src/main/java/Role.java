public enum Role {
    STAFF(0.1),
    EXECUTIVE(0.3),
    MANAGER(0.2);
    private Double percent;
    Role(Double percent){
        this.percent = percent;
    }
    public Double getPercent(){
        return percent;
    }

}
