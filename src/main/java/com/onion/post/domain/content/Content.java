package com.onion.post.domain.content;

import com.onion.post.domain.common.DateTimeInfo;

public abstract class Content {
    String contentText;
    DateTimeInfo dateTimeInfo;

    public Content(String contentText) {
        checkText(contentText);
        this.contentText = contentText;
        this.dateTimeInfo = new DateTimeInfo();
    }

    public void updateContent(String updateContent) {
        checkText(updateContent);
        this.contentText = updateContent;
        this.dateTimeInfo.updateEditDateTime();
    }

    protected abstract void checkText(String contentText);

    public String getContentText() {
        return contentText;
    }
}
