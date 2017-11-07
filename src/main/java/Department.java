import org.apache.ignite.cache.query.annotations.QuerySqlField;

public class Department {
    @QuerySqlField
    private int depId;
    @QuerySqlField
    private String depName;
    @QuerySqlField
    private String role;

    public Department(int depId, String depName, String role) {
        this.depId = depId;
        this.depName = depName;
        this.role = role;
    }

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    @Override
    public String toString() {
        return "Department{" +
                "depId=" + depId +
                ", depName='" + depName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
