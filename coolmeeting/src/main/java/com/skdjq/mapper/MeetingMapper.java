package com.skdjq.mapper;

import com.skdjq.model.Meeting;
import org.apache.ibatis.annotations.Param;

public interface MeetingMapper {
    Integer addMeeting(Meeting meeting);

    void addParticipants(@Param("meetingid") Integer meetingid, @Param("mps") Integer[] mps);
}
