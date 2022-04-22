student_list = ["A", "B", "C"]
subjects_list = ["Maths", "Science", "English", "History"]
marks = [40, 23, 69]
# ISSUE -- question meaning


zipped = zip(student_list, subjects_list, marks)
mappedList = list(map(max, zip(*zipped)))


print("Lexiographically largest name : ", mappedList[0])
print("Lexiographically largest subject : ", mappedList[1])
print("Largest marks : ", mappedList[2])