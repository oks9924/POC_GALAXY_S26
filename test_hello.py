import pytest

# 테스트 함수 매개변수에 'record_xml_attribute'를 반드시 넣어주세요.
def test_say_hello(record_xml_attribute):
    # [중요] Polarion의 테스트 케이스 ID인 TEST-1234를 입력합니다.
    # 이 줄이 있어야 Polarion의 아이템과 소스 코드가 연결됩니다.
    record_xml_attribute("testcase_id", "TEST-1234") 
    
    # 실제 테스트 로직
    print("Hello Polarion!")
    assert 1 + 1 == 2