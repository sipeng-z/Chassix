package com.casting.domain.entity;

public class CastingOEETime {


    private Integer plannedRunningTime;
    private Integer preventiveMaintenance;
    private Integer setupPreparation;

    public Integer getLunchTime() {
        return lunchTime;
    }

    public void setLunchTime(Integer lunchTime) {
        this.lunchTime = lunchTime;
    }

    public Integer getBreakTime() {
        return breakTime;
    }

    public void setBreakTime(Integer breakTime) {
        this.breakTime = breakTime;
    }

    public CastingOEETime() {

    }

    public Integer getPlannedRunningTime() {
        return plannedRunningTime;
    }

    public void setPlannedRunningTime(Integer plannedRunningTime) {
        this.plannedRunningTime = plannedRunningTime;
    }

    public Integer getPreventiveMaintenance() {
        return preventiveMaintenance;
    }

    public void setPreventiveMaintenance(Integer preventiveMaintenance) {
        this.preventiveMaintenance = preventiveMaintenance;
    }

    public Integer getSetupPreparation() {
        return setupPreparation;
    }

    public void setSetupPreparation(Integer setupPreparation) {
        this.setupPreparation = setupPreparation;
    }

    public Integer getChangeOvers() {
        return changeOvers;
    }

    public void setChangeOvers(Integer changeOvers) {
        this.changeOvers = changeOvers;
    }

    public Integer getUnplannedDowntime() {
        return unplannedDowntime;
    }

    public void setUnplannedDowntime(Integer unplannedDowntime) {
        this.unplannedDowntime = unplannedDowntime;
    }

    public Integer getActuallyRunningTime() {
        return actuallyRunningTime;
    }

    public void setActuallyRunningTime(Integer actuallyRunningTime) {
        this.actuallyRunningTime = actuallyRunningTime;
    }

    private Integer changeOvers;
    private Integer unplannedDowntime;
    private Integer actuallyRunningTime;
    private Integer lunchTime;
    private Integer breakTime;


}
