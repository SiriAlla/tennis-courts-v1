package com.tenniscourts.audit;

import com.tenniscourts.config.persistence.BaseEntity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The type Custom audit entity listener.
 */
public class CustomAuditEntityListener {

    /**
     * The constant USER_SYSTEM_ID.
     */
    public final static Long USER_SYSTEM_ID = 1L;

    /**
     * Pre update.
     *
     * @param baseEntity the base entity
     * @throws UnknownHostException the unknown host exception
     */
    @PreUpdate
    public void preUpdate(BaseEntity baseEntity) throws UnknownHostException {

        baseEntity.setDateUpdate(LocalDateTime.now());
        if (Objects.isNull(baseEntity.getUserUpdate())) {
            baseEntity.setUserUpdate(USER_SYSTEM_ID);
        }
        if (Objects.isNull(baseEntity.getIpNumberUpdate())) {
            baseEntity.setIpNumberUpdate(InetAddress.getLocalHost().getHostAddress());
        }
    }

    /**
     * Pre persist.
     *
     * @param baseEntity the base entity
     * @throws UnknownHostException the unknown host exception
     */
    @PrePersist
    public void prePersist(BaseEntity baseEntity) throws UnknownHostException {
        baseEntity.setDateUpdate(LocalDateTime.now());
        if (Objects.isNull(baseEntity.getUserUpdate())) {
            baseEntity.setUserUpdate(USER_SYSTEM_ID);
        }
        baseEntity.setDateCreate(LocalDateTime.now());
        if (Objects.isNull(baseEntity.getUserCreate())) {
            baseEntity.setUserCreate(USER_SYSTEM_ID);
        }
        if (Objects.isNull(baseEntity.getIpNumberCreate())) {
            baseEntity.setIpNumberUpdate(InetAddress.getLocalHost().getHostAddress());
        }
        if (Objects.isNull(baseEntity.getIpNumberCreate())) {
            baseEntity.setIpNumberCreate(InetAddress.getLocalHost().getHostAddress());
        }
    }
}