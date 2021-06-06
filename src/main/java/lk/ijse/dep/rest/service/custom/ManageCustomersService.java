package lk.ijse.dep.rest.service.custom;

import lk.ijse.dep.rest.dto.CustomerDTO;
import lk.ijse.dep.rest.service.SuperService;

import java.util.List;

public interface ManageCustomersService extends SuperService {

    List<CustomerDTO> getCustomers();

    void createCustomer(CustomerDTO dto);

    void updateCustomer(CustomerDTO dto);

    void deleteCustomer(String customerID);

    CustomerDTO findCustomer(String id);

    List<CustomerDTO> findCustomersByAddress(String address);


}
