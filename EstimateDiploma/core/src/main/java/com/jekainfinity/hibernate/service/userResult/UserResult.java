package com.jekainfinity.hibernate.service.userResult;

import com.jekainfinity.hibernate.entity.rootsUser.User;
import com.jekainfinity.hibernate.entity.tasks.AbstractTask;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

@Entity
@Table(name = "USER_RESULT")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "USER_RESULT_TYPE", discriminatorType = DiscriminatorType.STRING)
public abstract class UserResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_RESULT_ID",unique = true,  nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    @Cascade({CascadeType.ALL})
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TASK_ID")
    @Cascade({CascadeType.ALL})
    private AbstractTask abstractTask;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AbstractTask getAbstractTask() {
        return abstractTask;
    }

    public void setAbstractTask(AbstractTask abstractTask) {
        this.abstractTask = abstractTask;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}