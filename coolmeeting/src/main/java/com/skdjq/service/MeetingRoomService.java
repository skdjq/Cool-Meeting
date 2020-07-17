package com.skdjq.service;

import com.skdjq.model.MeetingRoom;

import java.util.List;

public interface MeetingRoomService {
    List<MeetingRoom> getAllMr();

    MeetingRoom getMrById(Integer roomid);

    Integer updateroom(MeetingRoom meetingRoom);

    Integer doAddMr(MeetingRoom meetingRoom);
}
