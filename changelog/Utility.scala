object Utility:
  def requireCmd(cmd: String): Unit =
    if os.proc("which", cmd).call(check = false).exitCode != 0 then
      println(s"Please install $cmd")
      sys.exit(1)
