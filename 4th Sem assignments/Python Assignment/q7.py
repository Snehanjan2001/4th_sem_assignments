import os




def findFiles(initial_directory_path, start="- "):
    for i in os.listdir(initial_directory_path):
        current_path = os.path.join(initial_directory_path, i)
        if os.path.isdir(current_path):
            print(start + current_path)
            findFiles(current_path, start + "- ")
        else:
            print(start + current_path)


findFiles("/C:\Users\DELL\Desktop\Python Assignment")
