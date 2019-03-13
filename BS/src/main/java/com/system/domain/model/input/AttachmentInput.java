package com.system.domain.model.input;

import com.system.domain.entity.Attachment;

import java.util.List;

public class AttachmentInput extends Attachment {
    private List<AttachmentInput> attachment;

    public List<AttachmentInput> getAttachment() {
        return attachment;
    }

    public void setAttachment(List<AttachmentInput> attachment) {
        this.attachment = attachment;
    }
}
