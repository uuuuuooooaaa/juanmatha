package lk.ijse.dep.rest.service.custom.impl;

import lk.ijse.dep.rest.dto.CustomerDTO;
import lk.ijse.dep.rest.entity.Customer;
import lk.ijse.dep.rest.repository.CustomerRepository;
import lk.ijse.dep.rest.service.Converter;
import lk.ijse.dep.rest.service.custom.ManageCustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ManageCustomersServiceImpl implements ManageCustomersService {

    private CustomerRepository customerDAO;

    @Autowired
    public ManageCustomersServiceImpl(CustomerRepository customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Transactional(readOnly = true)
    public List<CustomerDTO> getCustomers() {
        return Converter.getDTOList(customerDAO.findAll());
    }

    public void createCustomer(CustomerDTO dto) {
        customerDAO.save(Converter.getEntity(dto));
    }

    public void updateCustomer(CustomerDTO dto) {
        customerDAO.save(Converter.getEntity(dto));
    }

    public void deleteCustomer(String customerID) {
        customerDAO.deleteById(customerID);
    }

    public CustomerDTO findCustomer(String id) {
        return customerDAO.findById(id).map(Converter::<CustomerDTO>getDTO).orElse(null);
    }

//    @Override
//    public List<CustomerDTO> findCustomersByAddress(String address) {
//        List<Customer> customers = customerDAO.findCustomersByAddressLike(address+"%");
//        return Converter.getDTOList(customers);
//    }

    @Override
    public List<CustomerDTO> findCustomersByAddress(String address) {
        List<Customer> customers = customerDAO.someCustomers(address + "%");
        return Converter.getDTOList(customers);
    }

}
