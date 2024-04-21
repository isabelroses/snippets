# load this into repl with `:l path/to/file.nix`
{
  pkgs ? import <nixpkgs> {},
  lib ? pkgs.lib,
  ...
}: {
  load = lib.map (x: "foo" + x) ["bar" "bat" "baz"];
}
