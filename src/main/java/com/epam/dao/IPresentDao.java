package com.epam.dao;

import com.epam.entity.Present;

public interface IPresentDao {
    Present present = new Present();
    void writePresent(Present present);
    Present readPresent();

}
