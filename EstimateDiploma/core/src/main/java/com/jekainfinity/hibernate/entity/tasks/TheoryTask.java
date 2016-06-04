package com.jekainfinity.hibernate.entity.tasks;

import com.jekainfinity.hibernate.entity.Question;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue(value = "theoryTask")
public class TheoryTask extends AbstractTask {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "theoryTask")
    @Cascade({CascadeType.ALL})
    private Set<Question> questions = new HashSet<Question>(0);

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public void addQuestion(Question question){
        questions.add(question);
    }

}
