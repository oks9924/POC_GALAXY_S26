# {@wi.implements POC_GALAXY_S26/TEST-1234}
# 이 주석은 소스 코드와 폴라리온 아이템을 연결하는 '리소스 추적성' 태그입니다.
class SomeClass:
    def test_someMethod(self):
        # 성공 케이스: XML에 <testcase name="test_someMethod" classname="SomeClass"... /> 생성
        print("Executing success test")
        assert 1 + 1 == 2

    def test_otherMethod(self):
        # 실패 케이스: XML에 <failure> 태그가 생성됩니다.
        print("Executing failure test")
        assert 1 + 1 == 3, "failure message"