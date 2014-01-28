/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Tasks. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package programmersguide.workingwithcalendars.definingweekdays.java;

import com.aspose.tasks.*;

import java.util.Date;

public class DefiningWeekdays
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/workingwithcalendars/definingweekdays/data/";

        //Create a project instance
        Project prj = new Project();

        //Define Calendar
        Calendar cal = new Calendar();
        cal.setUid(1);
        cal.setName("Calendar1");
        prj.getCalendars().add(cal);

        //Add working days monday through thursday with default timings
        cal.getDays().add(WeekDay.createDefaultWorkingDay(DayType.Monday));
        cal.getDays().add(WeekDay.createDefaultWorkingDay(DayType.Tuesday));
        cal.getDays().add(WeekDay.createDefaultWorkingDay(DayType.Wednesday));
        cal.getDays().add(WeekDay.createDefaultWorkingDay(DayType.Thursday));
        cal.getDays().add(new WeekDay(DayType.Saturday));
        cal.getDays().add(new WeekDay(DayType.Sunday));

        //Set friday as short working day
        WeekDay myWeekDay = new WeekDay(DayType.Friday);

        //Sets working time. Only time part of DateTime is important
        WorkingTime wt1 = new WorkingTime();
        java.util.Calendar calTime = java.util.Calendar.getInstance();

        calTime.set(1,1,1,9,0,0);
        Date date = calTime.getTime();
        wt1.setFromTime(date);

        calTime.set(1,1,1,12,0,0);
        date = calTime.getTime();
        wt1.setToTime(date);

        WorkingTime wt2 = new WorkingTime();

        calTime.set(1,1,1,13,0,0);
        date = calTime.getTime();
        wt2.setFromTime(date);

        calTime.set(1,1,1,16,0,0);
        date = calTime.getTime();
        wt2.setToTime(date);

        myWeekDay.getWorkingTimes().add(wt1);
        myWeekDay.getWorkingTimes().add(wt2);
        myWeekDay.setDayWorking(true);
        cal.getDays().add(myWeekDay);
        prj.calcCalendarUids();

        //Save the Project
        prj.save(dataDir + "Project.Xml", SaveFileFormat.XML);

        //Display result of conversion.
        System.out.println("Process completed Successfully");

    }
}




