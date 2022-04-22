import pytest

@pytest.mark.parametrize("input1, input2, expected", [(2, 2, 4),(2, 3, 8),(1, 9, 1),(0, 9, 0)])
def test_q21(input1, input2, expected):
    assert input1**input2 == expected

# CMD => pytest q21.py