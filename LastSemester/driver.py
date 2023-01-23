import json, csv


class Playlist(object):

    PlayListData = None
    SongList = None
    def __init__(self, FileData):
        self.PlayListData = []
        self.SongList = FileData

    def AddSong(self, SongData):

        if not SongData in self.PlayListData:
            self.PlayListData.append(SongData) #Append, I am going to treat this as a stack
        else:
            print("Song already Added!")

    def RemoveLastSong(self):
        self.PlayListData.pop() # Aye there we go, push and pop!

    def RemoveSong(self, SongToRemove): # added for scalability...

        for SongData in self.PlayListData:
            pass

    def GetPlaylist(self):
        SongList = []

        for Data in self.PlayListData:
            SongList.append(Data['title'])

        return SongList

    def DisplaySongs(self):
        for SongData in self.SongList:
            if not SongData in self.PlayListData:
                print(SongData)

    def DisplaySpecificSong(self, ID):
        for SongData in self.SongList:
            if SongData['id'] == ID:
                return SongData
        return None #Invalid song ID

    def OutputPlaylist(self, PlaylistName):

        if self.PlayListData == []:
            return print("No songs in playlist!")

        MyFile = open('./'+ PlaylistName +'.csv', 'w', newline='')
        Writer = csv.writer(MyFile)

        IsTop = True
        for Data in self.PlayListData:
            if IsTop:
                IsTop = False
                Header = Data.keys()
                Writer.writerow(Header)
                Writer.writerow(Data.values())
            else:
                Writer.writerow(Data.values())



        MyFile.close()



class DataStream(object):

    FileLoaded = None
    FileData = None

    def __init__(self):
        try:
            self.JsonStream = json.load(open('./Test.json', 'r'))
            self.FileLoaded = True
            self.FileData = []
            self.ParseJsonFile()
        except:
            print("Issue loading file to data stream!")
            self.FileLoaded = False
    def ParseJsonFile(self):

        MyFile = self.JsonStream
        for Data in MyFile:
            for Song in MyFile[Data]: #Loop the list to get each song
                self.FileData.append(Song) # Append so we can move to playlist class.






class Driver(object):

    def __init__(self):

        MyInput = DataStream()
        UserPlayList = Playlist(MyInput.FileData)

        if MyInput.FileLoaded:

            print("Loading songs!")

            MyInput = None

            while True:

                UserPlayList.DisplaySongs()
                MyInput = input("Please select a song out of the list of song ID's or enter x to exist! ")

                if not MyInput.isnumeric():
                    if MyInput == 'x':
                        UserPlayList.OutputPlaylist(input("Saving songs to csv playlist! Please enter a name! "))
                        break
                    else:
                        print("Invalid input!")
                else:

                    MyInput = int(MyInput) #Convert to int
                    SongData = UserPlayList.DisplaySpecificSong(MyInput)

                    if SongData:
                        Confirm = input("Add {} to your playlist? Type y or n. ".format(SongData['title'])) # y or n to add...
                        if Confirm.lower() == 'y':
                            UserPlayList.AddSong(SongData)
                            input("Press enter to continue! Current Songs {}".format(UserPlayList.GetPlaylist()))
                            print(end='\n\n\n\n')
                    else:
                        print("Song ID {}, does not exist!".format(MyInput))
        else:
            pass



Driver()
