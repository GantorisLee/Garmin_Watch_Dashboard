package coachingmateanalytics.coachingmate.entity;

public class Program_status {
    private String program_id;
    private String user_id;
    private Number status;

    public Program_status(String program_id, String user_id, Number status) {
        this.program_id = program_id;
        this.user_id = user_id;
        this.status = status;
    }

    public String getProgram_id() {
        return program_id;
    }

    public void setProgram_id(String program_id) {
        this.program_id = program_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Number getStatus() {
        return status;
    }

    public void setStatus(Number status) {
        this.status = status;
    }
}