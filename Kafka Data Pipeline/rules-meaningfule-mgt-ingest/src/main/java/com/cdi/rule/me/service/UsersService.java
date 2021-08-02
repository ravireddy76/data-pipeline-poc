package com.cdi.rule.me.service;


import com.cdi.domain.model.User;
import com.cdi.domain.model.UserGroup;
import com.cdi.domain.model.UserRole;
import com.cdi.domain.repository.DataRepository;
import com.cdi.domain.util.AppUtils;
import com.cdi.domain.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
/**
 * UsersService class used to consume message from kafka topics and ingest data into
 * target tables in MS SQL server.
 *
 * @author Temam G.
 * @CopyRight (C) All rights reserved to CDI Inc. It's Illegal to reproduce this code.
 */
@Service
@Slf4j
public class UsersService {

    @Autowired
    private DataRepository dataRepository;

//    @KafkaListener(topics = "${topic.t_users}")
//    public void usersListener(@Payload String messagePayload) throws Exception {
//        log.info("UsersService:usersListener::Message: {}", messagePayload);
//
//        /* Build the users from kafka message. */
//        Map<String, Object> usersMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
//        User user = buildUser(usersMessage);
//
//        /* Save or persist the data into the table. */
//        dataRepository.save(user);
//        log.info("User is Saved/Updated for the id: {} ", user.getId());
//    }

//    @KafkaListener(topics = "${topic.t_user_roles}")
//    public void userRolesListener(@Payload String messagePayload) throws Exception {
//        log.info("Users:usersListener::Message: {}", messagePayload);
//
//        /* Build the transcription template from kafka message. */
//        Map<String, Object> userRolesMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
//        UserRole userRole = buildUserRole(userRolesMessage);
//
//        /* Save or persist the data into the table. */
//        dataRepository.save(userRole);
//        log.info("UserRole is Saved/Updated for the id: {} ", userRole.getId());
//    }

//    @KafkaListener(topics = "${topic.t_user_groups}")
//    public void userGroupsListener(@Payload String messagePayload) throws Exception {
//        log.info("UserGroups:userGroupsListener::Message: {}", messagePayload);
//
//        /* Build the transcription template from kafka message. */
//        Map<String, Object> userGroupsMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
//        UserGroup userGroup = buildUserGroup(userGroupsMessage);
//
//        /* Save or persist the data into the table. */
//        dataRepository.save(userGroup);
//        log.info("UserGroup is Saved/Updated for the id: {} ", userGroup.getId());
//    }

    /**
     * Method to build user
     * @param usersMessage
     * @return
     */
    private User buildUser(Map<String, Object> usersMessage) throws Exception{
//        Timestamp createdDate = AppUtils.convertToTimeStamp((String) usersMessage.get("LastModified"));
        List<String> orderingFacilitiesData = (List<String>) usersMessage.get("ordering_facilities");
        List<Integer> facilitiesData = (List<Integer>) usersMessage.get("facilities");
        String orderingFacilities = AppUtils.convertArrayToValue(orderingFacilitiesData);
        String facilities = AppUtils.convertNumbersToValue(facilitiesData);
        String passwordChangedDtData = (String) usersMessage.get("password_changed_dt");
        OffsetDateTime passwordChangedDt = AppUtils.convertToOffsetTimeStamp(passwordChangedDtData);
        long id = new Long((Integer) usersMessage.get("id")).longValue();

        User user =  new User();

        user.setId(id);
        user.setHasDeleted((boolean) usersMessage.get("has_deleted"));
        user.setOrderingFacilities(orderingFacilities);
        user.setUserPermissions((String) usersMessage.get("user_permissions"));
        user.setActive((boolean) usersMessage.get("is_active"));
        user.setSalt((String) usersMessage.get("salt"));
        user.setCompanyId((Integer) usersMessage.get("company_id"));
        user.setMiddleInitial((String) usersMessage.get("middle_initial"));
        user.setLastName((String) usersMessage.get("last_name"));
//        user.setFailed((String) usersMessage.get("salt"));
        user.setSuffix((String) usersMessage.get("suffix"));
        user.setUserSettings((String) usersMessage.get("user_settings"));
        user.setPassword((String) usersMessage.get("password"));
        user.setUserType((String) usersMessage.get("user_type"));
        user.setMarketingRepInfo((String) usersMessage.get("marketing_rep_info"));
        user.setProviderId((Integer) usersMessage.get("provider_id"));
        user.setViewerConfig((String) usersMessage.get("viewer_config"));
        user.setDefaultFacilityId((Integer) usersMessage.get("default_facility_id"));
        user.setFacilities(facilities);
        user.setFirstName((String) usersMessage.get("first_name"));
        user.setUserGroupId((Integer) usersMessage.get("user_group_id"));
        user.setPasswordChangedDt(passwordChangedDt);
        user.setUsername((String) usersMessage.get("username"));

        return user;
    }


    /**
     * Method to build User Role
     * @param userRolesMessage
     * @return
     */
    private UserRole buildUserRole(Map<String, Object> userRolesMessage) throws Exception{
        Timestamp createdDate = AppUtils.convertToTimeStamp((String) userRolesMessage.get("LastModified"));

        UserRole userRole =  new UserRole();

        userRole.setCompanyId((Integer) userRolesMessage.get("company_id"));
//        userRole.setDeletedDt((Integer) userRolesMessage.get("deleted_dt"));
        userRole.setHasDeleted((boolean) userRolesMessage.get("has_deleted"));
//        userRole.setActive((boolean) userRolesMessage.get("is_active"));
//        userRole.setLastAction((String) userRolesMessage.get("LastAction"));
//        userRole.setLastModified(createdDate);
//        userRole.setPermissions((String) userRolesMessage.get("permissions"));
//        userRole.setRoleDescription((String) userRolesMessage.get("role_description"));
//        userRole.setRoleName((String) userRolesMessage.get("role_name"));

        return userRole;
    }

    /**
     * Method to build user Groups
     * @param userGroupsMessage
     * @return
     */
    private UserGroup buildUserGroup(Map<String, Object> userGroupsMessage) throws Exception{
        Timestamp createdDate = AppUtils.convertToTimeStamp((String) userGroupsMessage.get("LastModified"));

        UserGroup userGroup =  new UserGroup();

        userGroup.setAdGroupId((Integer) userGroupsMessage.get("ad_group_id"));
        userGroup.setCanDelete((boolean) userGroupsMessage.get("can_delete"));
        userGroup.setCompanyId((Integer) userGroupsMessage.get("company_id"));

        return userGroup;
    }

}
