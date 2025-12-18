package com.example.demo.repository;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.model.LeaveRequest;
import com.example.demo.model.EmployeeProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long>{
    List<LeaveRequest> findByEmployee(EmployeeProfile employee);
    @Query(
    "select 1 from LeaveRequest 1"+
    "where 1.employee.teamName = :teamName" +
    "and 1.status = 'APPROVED' "+
    "and 1.startDate<= :end" +
    "and 1.endDate>= :start"
    )
    List<LeaveRequest> findApprovedOverlappingForTeam(
        @Param("teamName") String teamName,
        @Param("start") LocalDate start,
        @Param("end") LocalDate end
    );    
}