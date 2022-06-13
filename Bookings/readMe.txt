A Cape Town conference venue has reservation requests for a particular date. The staff need to determine whether all requests can be accommodated.

A request consists of a start time, inclusive, and an end time, exclusive. The start time is no earlier than 8:00 am and the end time is no later than 10:00 pm. (All times are expressed in twelve-hour clock. Midday is 12:00 pm.)

All requests can be accommodated if there are no overlapping requests i.e. given any two requests, ri, rj, the end time for ri must be less-than-or-equal to the start time for rj, or the end time for rj must be less-than-or-equal to the start time for ri.

For simplicity, room size and seating capacity are not under consideration.

Write a program called 'Bookings.java' that accepts room reservation request data as input and that determines whether or not all requests can be accommodated.

Input will comprise a number of lines:

The first line will contain a value for N, the number of requests.
The next N lines will contain N room requests, one per line.


A room request comprises two twelve-hour clock times separated by a hyphen, ‘-‘. The first is the start time and the second is the end time.

The program will analyse the data and output 'Good to go.' if all reservations can be accommodated. If not, it will output 'Let's play Sardines! followed by the number of pairs of requests that clash.