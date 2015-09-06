package com.programmer.aim;

import com.programmer.step.Step;
import com.programmer.step.StepForm;
import org.hibernate.validator.constraints.NotBlank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by kolyan on 8/11/15.
 */
public class AimForm {

    private Long aimId;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    private Long priority;

    private Set<StepForm> stepForms;

    public AimForm() {
        stepForms = new HashSet<>();
    }

    public Long getAimId() {
        return aimId;
    }

    public void setAimId(Long aimId) {
        this.aimId = aimId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public Set<StepForm> getStepForms() {
        return stepForms;
    }

    public void setStepForms(Set<StepForm> stepForms) {
        this.stepForms = stepForms;
    }

    public Aim createAim() {
        Set<Step> steps = new HashSet<>();
        for(StepForm stepForm : stepForms)
            steps.add(stepForm.createStep());
        return new Aim(aimId, name, description, steps, priority);
    }
}
