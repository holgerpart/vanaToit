package com.bcs.vanaToit.domain.user.contact;

import com.bcs.vanaToit.service.login.UserRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ContactService {

    @Resource
    private ContactRepository contactRepository;

    public Contact addContact(UserRequest request) {
        Contact contact = new Contact();
        contact.setFirstName(request.getFirstName());
        contact.setLastName(request.getLastName());
        contactRepository.save(contact);
        return contact;
    }
}
