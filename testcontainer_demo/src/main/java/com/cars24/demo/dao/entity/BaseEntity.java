package com.cars24.demo.dao.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity {

  @Column(name = "created_at")
  // @CreationTimestamp
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  // @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Column(name = "created_by")
  // @CreatedBy
  private String createdBy;

  @Column(name = "updated_by")
  // @LastModifiedBy
  private String updatedBy;

  @PrePersist
  public void prePersist() {
    createdAt = LocalDateTime.now();
    updatedAt = LocalDateTime.now();
    // createdBy = LoggedUser.get();
  }

  @PreUpdate
  public void preUpdate() {
    updatedAt = LocalDateTime.now();
    // updatedBy = LoggedUser.get();
  }

  @PreRemove
  public void preRemove() {

  }
}
