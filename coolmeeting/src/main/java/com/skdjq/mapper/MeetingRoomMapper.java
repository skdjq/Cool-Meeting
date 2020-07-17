package com.skdjq.mapper;

import com.skdjq.model.MeetingRoom;

import java.util.List;

public interface MeetingRoomMapper {
    List<MeetingRoom> getAllMr();

    MeetingRoom getMrById(Integer roomid);

    Integer updateroom(MeetingRoom meetingRoom);

    Integer doAddMr(MeetingRoom meetingRoom);
}
