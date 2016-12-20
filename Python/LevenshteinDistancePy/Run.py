import sys
import datetime
import os
import Algorithm.Calc
import lev.lib.xlrd

day = datetime.datetime.today().date()
time = datetime.datetime.today().time()
end_name = str(day) + ' ' + str(time)[0:8].replace(':', '-')

try:
    with lev.lib.xlrd.open_workbook(os.getcwd() + "/file_1.xlsx") as File1:
        DataSheet1 = File1.sheet_by_index(0)
        Data1 = [DataSheet1.col_values(0), DataSheet1.col_values(1)]
    with lev.lib.xlrd.open_workbook(os.getcwd() + "/file_2.xlsx") as File2:
        DataSheet2 = File2.sheet_by_index(0)
        Data2 = [DataSheet2.col_values(0), DataSheet2.col_values(1)]
except:
    FileNotFoundError
    input("File file_1.xlsx or file_2.xlsx not found. Press ENTER to exit.")
    sys.exit()

NO_ROWS = len(Data1[0]) * len(Data2[0])
print("You going to calculate " + str(NO_ROWS) + " rows")
print("Estimated time of completion is:", Algorithm.Calc.get_time_process(NO_ROWS), "minutes")
print("If you want to continue, enter 'y'. If you don't, press Enter:")

try:
    choice = input()
    if choice == 'y' or choice == 'Y':
        print("Enter the distance threshold Levenshtein. Recommended threshold: 7 - 8")
        start_timer = datetime.datetime.today()
        max_range = int(input())
        ResultList = Algorithm.Calc.start_calculate(Data1, Data2, max_range)  # start algorithm

        ResultFile = open(os.getcwd() + "/result" + end_name + ".csv", 'w')
        for i in range(0, len(ResultList)):
            ResultFile.write(ResultList[i] + '\n')

        print('Total time:', str(datetime.datetime.today() - start_timer)[0:7])
        print('Complete')
except:
    ValueError, TypeError
    print("Input error...")
input("Press ENTER to exit.")
