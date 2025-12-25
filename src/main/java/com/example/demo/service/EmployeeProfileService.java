public interface EmployeeProfileService {

    EmployeeProfile save(EmployeeProfile profile);

    EmployeeProfile update(Long id, EmployeeProfile profile);

    void deactivate(Long id);

    EmployeeProfile getById(Long id);

    List<EmployeeProfile> getByTeam(String team);
}
