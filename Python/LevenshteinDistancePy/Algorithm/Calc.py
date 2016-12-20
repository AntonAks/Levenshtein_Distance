import datetime


result = []


def start_calculate(strings1, strings2, levdist):

    start_time = datetime.datetime.today()
    """"Return list with two strings and Levenshtein distance"""
    result.append('ID_1' + '; '
                  + 'SKU_1' + '; '
                  + 'ID_2' + '; '
                  + 'SKU_2' + '; '
                  + 'LevDist' + '; '
                  + 'PercentageOfMatch')
    for i in range(1, len(strings1[1])):
        print('Execute:', str('%f' % (100 * i / len(strings1[1])))[0:4], '%', datetime.datetime.today() - start_time)
        for j in range(1, len(strings2[1])):
            ld = get_levenshtein_distance(str(strings1[1][i]).lower(), str(strings2[1][j]).lower())
            accuracy = 1 - ld / len(strings1[1][i])
            if ld < int(levdist):
                result.append(str(strings1[0][i]) + '; '
                              + strings1[1][i] + '; '
                              + str(strings2[0][j]) + '; '
                              + strings2[1][j] + '; '
                              + str(ld) + '; '
                              + str(accuracy))
    return result


def get_levenshtein_distance(a, b):
    """"Calculates the Levenshtein distance between a and b."""
    n, m = len(a), len(b)
    if n > m:
        # Make sure n <= m, to use O(min(n,m)) space
        a, b = b, a
        n, m = m, n
    current_row = range(n+1)    # Keep current and previous row, not entire matrix

    for i in range(1, m+1):
        previous_row, current_row = current_row, [i]+[0]*n
        for j in range(1, n+1):
            add, delete, change = previous_row[j]+1, current_row[j-1]+1, previous_row[j-1]
            if a[j-1] != b[i-1]:
                change += 1
            current_row[j] = min(add, delete, change)
    return current_row[n]


def get_time_process(rows):
    time_mins = int(rows / 50000)
    return time_mins
