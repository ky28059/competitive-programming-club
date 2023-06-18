defmodule Solution do
  @spec my_sqrt(x :: integer) :: integer
  def my_sqrt(x) do
    my_sqrt(x, 0)
  end

  defp my_sqrt(x, i) when x > i * i, do: my_sqrt(x, i + 1)
  defp my_sqrt(x, i) when x == i * i, do: i
  defp my_sqrt(x, i), do: i - 1
end
