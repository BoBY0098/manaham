package manamaham.amirhossein.kafkatask.service;

import lombok.RequiredArgsConstructor;
import manamaham.amirhossein.kafkatask.entity.Employee;
import manamaham.amirhossein.kafkatask.entity.EmployeeReq;
import manamaham.amirhossein.kafkatask.entity.Task;
import manamaham.amirhossein.kafkatask.entity.TaskReq;
import manamaham.amirhossein.kafkatask.repository.EmployeeRepository;
import manamaham.amirhossein.kafkatask.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final TaskRepository taskRepository;

    public void saveEmployee(EmployeeReq req){

        Employee employee = new Employee();

        employee.setId(req.getId());
        employee.setName(req.getName());
        employee.setDepartment(req.getDepartment());
        employee.setPosition(req.getPosition());
        employee.setDueDate(req.getDueDate());
        employee.setSalary(req.getSalary());

        for (TaskReq item : req.getTasks()) {

            Task task = new Task();

            task.setId(item.getId());
            task.setDescription(item.getDescription());
            task.setStatus(item.getStatus());
            task.setEmployee(employee);
            task.setDueDate(item.getDueDate());

            taskRepository.save(task);
        }
        employeeRepository.save(employee);
    }
}
