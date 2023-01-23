class VolumeObject(object):

    def __init__(self, l=0, w=0, h=0):
        self.Volume = (l*w*h) / 3

    @property
    def Volume(self):
        return self._Volume

    @Volume.setter
    def Volume(self, Value):
        self._Volume = Value



    def __str__(self):
        return "Volume: {}".format(self.Volume)


def GetVolume(l,w,h): #Factory design pattern ;)
    return VolumeObject(l,w,h)

def Driver():

    TestCases = [{'l' : 7, 'w' : 6, 'h' : 9}, {'l' : 6.6, 'w' : 3.3, 'h' : 7.7}]
    Answers = []
    for TestCase in TestCases:
        Obj = GetVolume(TestCase.get('l'), TestCase.get('w'), TestCase.get('h'))
        Answers.append(Obj)

    for N in Answers:
        print(N, end="\n")


if __name__ == '__main__':
    Driver()